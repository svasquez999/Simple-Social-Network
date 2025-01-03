package SimpleSocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class represents a Social Network.
 * 
 * @author Saeed Vasquez
 */
public class SocialNetwork {
	private Map<String, User> users;
	
	/**
	 * Constructor that starts up the Social Network.
	 */
	public SocialNetwork() {
		this.users = new HashMap<>();
	}
	
	/** 
	 * This method adds a user to the Network
	 * 
	 * @param username
	 * @return - true, if the User was successfully added to the Network, else false.
	 */
	public boolean addUser(String username) {
		if(this.users.containsKey(username))
			return false;
		this.users.put(username, new User(username));
		return true;
	}
	
	/**
	 * This method removes a User from the Network.
	 * 
	 * @param username
	 * @return - true, if the User was successfully removed from the Network, false otherwise.
	 */
	public boolean removeUser(String username) {
		if(!this.users.containsKey(username))
			return false;
		User deletedUser = this.users.remove(username);
		
		for(User user : this.users.values()){
			user.removeFollower(deletedUser);
			user.removeFollowing(deletedUser);
		}
		
		return true;
	}
	
	/**
	 * This method creates a follow from follower to followee.
	 * @param follower - User following.
	 * @param followee - User being followed.
	 * @return - true if the follow is successful, else false.
	 */
	public boolean follow(String follower, String followee) {
		if(!this.users.containsKey(follower) || !this.users.containsKey(followee))
			return false;
		User followerUser = this.users.get(follower);
		User followeeUser = this.users.get(followee);
		
		followerUser.addFollowing(followeeUser);
		followeeUser.addFollower(followerUser);
		return true;
	}
	
	/**
	 * This method creates an unfollow between two User's.
	 * @param follower - User following, to be unfollowing the followee.
	 * @param followee - User being followed, to be unfollowed by follower.
	 * @return - true if the unfollow is successful, else false.
	 */
	public boolean unfollow(String follower, String followee) {
		if(!this.users.containsKey(follower) || !this.users.containsKey(followee))
			return false;
		
		User followerUser = this.users.get(follower);
		User followeeUser = this.users.get(followee);
		
		followerUser.removeFollowing(followeeUser);
		followeeUser.removeFollower(followerUser);
		return true;
	}
	
	/**
	 * This method gets a list of all the User's in the network.
	 * 
	 * @return - List containing all the User's in the network.
	 */
	public List<User> getUsers(){
		List<User> users = new ArrayList<>();
		
		for(User user : this.users.values()) {
			users.add(user);
		}
		
		return users;
	}
	
	/**
	 * This method gets a User's followers.
	 * @param username
	 * @return - Set
	 */
	public Set<User> getFollowers(String username){
		return this.users.get(username).getFollowers();
	}
	
	/**
	 * This method gets a User's following
	 * @param username
	 * @return - Set
	 */
	public Set<User> getFollowing(String username){
		return this.users.get(username).getFollowing();
	}
	/** 
	 * This method gets the mutual followers between two users.
	 * @param user1
	 * @param user2
	 * @return - set that contains mutual followers. If either user or neither are in 
	 * the network, return null.
	 */
	public Set<User> getMutualFollowers(String user1, String user2){
		if(!this.users.containsKey(user1) || !this.users.containsKey(user2))
			return null;
		
		User u1 = this.users.get(user1);
		User u2 = this.users.get(user2);
		
		Set<User> mutual = new HashSet<>(u1.getFollowers());
		mutual.retainAll(u2.getFollowers());

		
		return mutual;
	}
}
