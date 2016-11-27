package com.barath.app.repositories;

import java.util.HashSet;
import java.util.Set;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.barath.app.model.Player;
import com.barath.app.model.Team;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;


@Repository
public class TeamRepository {
	

	private Logger logger=LoggerFactory.getLogger(TeamRepository.class);
	private static final String TEAM_COLLECTION_NAME="TEAM";
	private static final String TEAM_ID="TEAMID";
	private static final String TEAM_NAME="TEAMNAME";
	private static final String DEFAULT_DATABASE_NAME="test";
	
	private MongoClient mongoClient;	
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	@Value("${mongodb.database}")
	private String databaseName;	
	
	
	@Autowired
	public TeamRepository(MongoClient mongoClient){
		this.mongoClient=mongoClient;
		logger.info("Database name"+databaseName);
		this.databaseName= this.databaseName ==null? DEFAULT_DATABASE_NAME: this.databaseName;
		this.database=this.mongoClient.getDatabase(this.databaseName);
		this.collection=this.database.getCollection(TEAM_COLLECTION_NAME);
		if(this.collection ==null ){
			this.database.createCollection(TEAM_COLLECTION_NAME);
			this.collection=this.database.getCollection(TEAM_COLLECTION_NAME);
		}
	}

	public Team addTeam(Team team){
		if(logger.isInfoEnabled()){
			logger.info("Adding the team "+team.toString());
		}
		this.collection.insertOne(convertObjectToDocument(team));
		return readTeam(team.getTeamId());
	}
	
	
	public Team readTeam(long teamId){
		if(logger.isInfoEnabled()){
			logger.info("Reading the team with team id "+teamId);
		}
		Document document=new Document(TEAM_ID, teamId);
		FindIterable<Document> team=this.collection.find(document);		
		return convertDocumentToTeam(team.first());
	}
	
	public Team readTeamByName(String teamName){
		if(logger.isInfoEnabled()){
			logger.info("Reading the team with name "+teamName);
		}
		Document document=new Document(TEAM_NAME, teamName);
		FindIterable<Document> team=this.collection.find(document);		
		return convertDocumentToTeam(team.first());
	}
	
	
	public Team updateTeam(Team team){
		if(logger.isInfoEnabled()){
			logger.info("Updating the team "+team.toString());
		}
		Document document=this.collection.findOneAndUpdate(new Document(TEAM_ID, team.getTeamId()), convertObjectToDocument(team));
		return convertDocumentToTeam(document);
	}
	
	
	public boolean deleteTeam( long teamId){
		if(logger.isInfoEnabled()){
			logger.info("Deleting  the team with team id "+teamId);
		}
		Document document=new Document(TEAM_ID,teamId);
		
		DeleteResult result=this.collection.deleteOne(document);
		if(result !=null && result.getDeletedCount() > 0 ){
			logger.info("Deleted successfully  "+result+" Count is "+result.getDeletedCount());
			return true;
		}
			
		return false;
	}
	
	public boolean deleteTeamByName( String teamName){
		if(logger.isInfoEnabled()){
			logger.info("Deleting  the team with teamName "+teamName);
		}
		Document document=new Document(TEAM_NAME,teamName);
		
		DeleteResult result=this.collection.deleteOne(document);
		if(result !=null && result.getDeletedCount() > 0 ){
			logger.info("Deleted successfully  "+result+" Count is "+result.getDeletedCount());
			return true;
		}
			
		return false;
	}
	
	public Set<Team> findAllTeams(){		
		FindIterable<Document> documents=this.collection.find();
		Set<Team> teams=new HashSet<Team>();
		if(documents != null){
			documents.forEach((Document document)->{
				teams.add(convertDocumentToTeam(document));
			});
			teams.stream().forEach(System.out::println);
		}
		
		return teams;
	}
	
	
	public Document convertObjectToDocument(Team team){
		Assert.notNull(team,"Team object cannot be null");
		if(logger.isInfoEnabled()){
			logger.info("Converting team object "+team.toString());
		}
		Document document=new Document();
		document.append(TEAM_ID, team.getTeamId());
		document.append(TEAM_NAME, team.getTeamName());				
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
	
	public MongoCollection<Document> getTeamCollection(){
		if(logger.isInfoEnabled()){
			logger.info("Getting the Team colection  "+this.database);
		}
		if(this.collection ==null){
			MongoDatabase database=getDatabase();
			this.collection=database.getCollection(TEAM_COLLECTION_NAME);
		}
		
		return this.collection;
	}
	
	public Team convertDocumentToTeam(Document document){
		Team team=null;
		if(document !=null){
			team=new Team((long)document.get(TEAM_ID),(String)document.get(TEAM_NAME));
			if(logger.isInfoEnabled()){
				logger.info("Converting document to Team instance  "+document);
				logger.info("Converting document to Team instance  "+team.toString());
			}		
		}
		return team;
	}

}
