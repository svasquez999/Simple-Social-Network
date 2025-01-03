package SimpleSocialNetwork;

public class Main {

	public static void main(String args[]) {
		SocialNetwork network = new SocialNetwork();
		
		network.addUser("Sasha");
		network.addUser("Candace");
		network.addUser("Max");
		network.addUser("Lucas");
		network.addUser("Hensel");
		
		System.out.println(network.follow("Max", "Lucas"));
		System.out.println(network.follow("Max", "Candace"));
		
		System.out.println(network.follow("Darius", "Max"));

		System.out.println(network.getFollowing("Max"));
		
		network.follow("Sasha", "Candace");
		network.follow("Hensel", "Candace");
		network.follow("Sasha", "Lucas");
		network.follow("Hensel", "Lucas");
		network.follow("Max", "Candace");
		network.follow("Lucas", "Hensel");
		
		System.out.println(network.getUsers());
		
		System.out.println(network.getFollowing("Sasha"));
		
		System.out.println("Mutual followers of Sasha and Hensel: ");
		System.out.println(network.getMutualFollowers("Candace", "Lucas"));
		
		System.out.println(network.unfollow("Max", "Candace"));
		
	}
}
