package com.barath.app.repositories;

import java.util.HashSet;
import java.util.Set;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.barath.app.model.Player;
import com.barath.app.model.Team;
import com.mongodb.DBRef;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Repository
public class PlayerRepository {
	
	private Logger logger=LoggerFactory.getLogger(PlayerRepository.class);
	private static final String PlAYER_COLLECTION_NAME="PLAYER";
	private static final String PLAYER_ID="PLAYERID";
	private static final String PLAYER_NAME="PLAYERNAME";
	private static final String PLAYER_AGE="PLAYERAGE";
	private static final String DEFAULT_DATABASE_NAME="test";
	private MongoClient mongoClient;	
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	@Value("${mongodb.database}")
	private String databaseName;
	
	private TeamRepository teamRepository;
	
	@Autowired
	public PlayerRepository(MongoClient mongoClient,TeamRepository teamRepository){
		this.mongoClient=mongoClient;
		this.databaseName= this.databaseName ==null? DEFAULT_DATABASE_NAME: this.databaseName;
		this.database=this.mongoClient.getDatabase(databaseName);
		this.collection=this.database.getCollection(PlAYER_COLLECTION_NAME);
		this.teamRepository=teamRepository;
		if(this.collection ==null ){
			this.database.createCollection(PlAYER_COLLECTION_NAME);
			this.collection=this.database.getCollection(PlAYER_COLLECTION_NAME);
		}
	}

	public Player addPlayer(Player player){
		if(logger.isInfoEnabled()){
			logger.info("Adding the player "+player.toString());
		}
		this.collection.insertOne(convertObjectToDocument(player));
		return readPlayer(player.getPlayerId());
	}
	
	
	public Player readPlayer(long playerId){
		if(logger.isInfoEnabled()){
			logger.info("Reading the player with player id "+playerId);
		}
		Document document=new Document(PLAYER_ID, playerId);
		FindIterable<Document> team=this.collection.find(document);		
		return convertDocumentToPlayer(team.first());
	}
	
	public Player readPlayerByName(String playerName){
		if(logger.isInfoEnabled()){
			logger.info("Reading the player with name "+playerName);
		}
		Document document=new Document(PLAYER_NAME, playerName);
		FindIterable<Document> team=this.collection.find(document);		
		return convertDocumentToPlayer(team.first());
	}
	
	
	public Player updatePlayer(Player player){
		if(logger.isInfoEnabled()){
			logger.info("Updating the player "+player.toString());
		}
		Document documentToUpdate=new Document();
		documentToUpdate.append(PLAYER_NAME,player.getPlayerName());
		documentToUpdate.append(PLAYER_AGE, player.getPlayerAge());
		documentToUpdate.append("TEAMID", player.getTeam().getTeamId());
		Bson updateDocument=new Document("$set",documentToUpdate);
		UpdateResult update=this.collection.updateOne(new Document(PLAYER_ID,player.getPlayerId()), updateDocument);
		if(update !=null){
			logger.info("Updated result is "+update.getModifiedCount());
		}
		
		//Document document=this.collection.findOneAndUpdate(new Document(PLAYER_ID, player.getPlayerId()),updateDocument );
		return readPlayer(player.getPlayerId());
	}
	
	public boolean deletePlayer( long playerId){
		if(logger.isInfoEnabled()){
			logger.info("Deleting  the player with player id "+playerId);
		}
		Document document=new Document(PLAYER_ID,playerId);
		
		DeleteResult result=this.collection.deleteOne(document);
		if(result !=null && result.getDeletedCount() > 0 ){
			logger.info("Deleted successfully  "+result+" Count is "+result.getDeletedCount());
			return true;
		}
			
		return false;
	}
	
	public boolean deletePlayerByName(String playerName) {
		if(logger.isInfoEnabled()){
			logger.info("Deleting  the player with player name "+playerName);
		}
		Document document=new Document(PLAYER_NAME,playerName);		
		DeleteResult result=this.collection.deleteOne(document);
		if(result !=null && result.getDeletedCount() > 0 ){
			logger.info("Deleted successfully  "+result+" Count is "+result.getDeletedCount());
			return true;
		}
			
		return false;
		
	}
	
	public Set<Player> findAllPlayers(){		
		FindIterable<Document> documents=this.collection.find();
		Set<Player> players=new HashSet<Player>();
		if(documents != null){
			documents.forEach((Document document)->{
				players.add(convertDocumentToPlayer(document));
			});
			players.stream().forEach(System.out::println);
		}
		
		return players;
	}
	public Document convertObjectToDocument(Player player){
		Assert.notNull(player,"Player object cannot be null");
		if(logger.isInfoEnabled()){
			logger.info("Converting player object "+player.toString());
		}
		Document document=new Document();
		document.append(PLAYER_ID, player.getPlayerId());
		document.append(PLAYER_NAME, player.getPlayerName());	
		document.append(PLAYER_AGE, player.getPlayerAge());	
		DBRef dbRef=new DBRef("TEAM", player.getTeam().getTeamId());
		document.append("TEAMID", dbRef.getId());	
		return document;
	}
	
	public MongoDatabase getDatabase(){
		
		if(logger.isInfoEnabled()){
			logger.info("Getting the database "+this.database);
		}
		if(this.database == null){
			return this.mongoClient.getDatabase(databaseName);
		}
		
		return this.database;
	}
	
	public MongoCollection<Document> getPlayerCollection(){
		if(logger.isInfoEnabled()){
			logger.info("Getting the Player colection  "+this.database);
		}
		if(this.collection ==null){
			MongoDatabase database=getDatabase();
			this.collection=database.getCollection(PlAYER_COLLECTION_NAME);
		}
		
		return this.collection;
	}
	
	
	
	public Player convertDocumentToPlayer(Document document){
		Player player=null;
		if(document !=null){
			Team team=this.teamRepository.readTeam((long)document.get("TEAMID"));			
			player=new Player((long)document.get(PLAYER_ID),(String)document.get(PLAYER_NAME),(int)document.get(PLAYER_AGE),team);
			if(logger.isInfoEnabled()){
				logger.info("Converting document to Team instance  "+document);
				
			}		
		}
		return player;
	}
	


}
