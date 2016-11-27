package com.barath.app.repositories;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.barath.app.model.Player;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

@Repository
public class PlayerRepository {
	
	private Logger logger=LoggerFactory.getLogger(PlayerRepository.class);
	private static final String PlAYER_COLLECTION_NAME="PLAYER";
	private static final String PLAYER_ID="PLAYERID";
	private static final String PLAYER_NAME="PLAYERNAME";
	private MongoClient mongoClient;	
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	@Value("${mongodb.database}")
	private String databaseName;
	
	private TeamRepository teamRepository;
	
	@Autowired
	public PlayerRepository(MongoClient mongoClient){
		this.mongoClient=mongoClient;
		this.database=this.mongoClient.getDatabase(databaseName);
		this.collection=this.database.getCollection(PlAYER_COLLECTION_NAME);
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
			logger.info("Reading the player "+playerId);
		}
	}
	
	public Player readPlayerByName(String playerName){
		if(logger.isInfoEnabled()){
			logger.info("Reading the player with name "+playerName);
		}
	}
	
	
	public Player updatePlayer(Player player){
		if(logger.isInfoEnabled()){
			logger.info("Updating the player "+player.toString());
		}
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
			
		retu
	
	
	public Document convertObjectToDocument(Player player){
		Assert.notNull(player,"Player object cannot be null");
		if(logger.isInfoEnabled()){
			logger.info("Converting player object "+player.toString());
		}
		Document document=new Document();
		document.append("PLAYERID", player.getPlayerId());
		document.append("PLAYERNAME", player.getPlayerName());		
		document.append("TEAMID", player.getTeam().getTeamId());	
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


}
