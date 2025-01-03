package SimpleSocialNetwork;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a person/account in the network.
 * 
 * @author Saeed Vasquez
 */
public class User {
	private String username;
	private Set<User> following;
	private Set<User> followers;
	
	/**
	 * Constructor that initializes a User
	 * 
	 * @param username
	 */
	public User(String username) {
		this.username = username;
		this.followers = new HashSet<>();
		this.following = new HashSet<>();
	}
	
	/**
	 * Gets the User's username.
	 * 
	 * @return - username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Gets the User's following set.
	 * 
	 * @return - Set that contains the User's following set.
	 */
	public Set<User> getFollowing(){
		return this.following;
	}
	
	/**
	 * Gets the User's followers set.
	 * 
	 * @return - Set that contains the User's followers set.
	 */
	public Set<User> getFollowers(){
		return this.followers;
	}
	
	/**
	 * This method adds a follower to the User.
	 * 
	 * @param user - User being added to the User's followers set.
	 * @return - false if the User wasn't successfully added, true otherwise.
	 */
	public boolean addFollower(User user) {
		return this.followers.add(user);
	}
	
	/**
	 * This method adds a User to the following set.
	 * 
	 * @param user - User that is added to the following set.
	 * @return - false if the User wasn't successfully added to the set, true otherwise.
	 */
	public boolean addFollowing(User user) {
		return this.following.add(user);
	}
	
	/**
	 * This method removes a User from the followers set.
	 * 
	 * @param user - User being removed from the followers set.
	 * @return - false if the User wasn't removed from the set.
	 */
	public boolean removeFollower(User user) {
		return this.followers.remove(user);
	}
	
	/**
	 * This method removes a User from the following set.
	 * 
	 * @param user - User being removed from the following set.
	 * @return - false if the User wasn't removed from the set.
	 */
	public boolean removeFollowing(User user) {
		return this.following.remove(user);
	}
	
	public String toString() {
		return this.username;
	}
}