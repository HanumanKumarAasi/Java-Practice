package concepts.heap.datastructure;

 import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
	// Maintaining the list of friends the user has.
	Map<Integer, Set<Integer> > friendsOfUser;
	int curr = 0;

	// To store the tweets sorted as most recent
	PriorityQueue<int[]> timeline;

	public Twitter()
	{
		friendsOfUser = new HashMap<>();
		curr = 0;
		timeline
			= new PriorityQueue<>((a, b) -> b[0] - a[0]);
	}

	// Function to add tweet in timeline for
	// the particular user
	void postTweet(int userId, int tweetId)
	{
		timeline.add(new int[] { curr++, tweetId, userId });
	}

	// Function to get top recent 10 tweets
	List<Integer> getNewsFeed(int userId)
	{
		List<Integer> ans = new ArrayList<>();
		PriorityQueue<int[]> userTimeline
			= new PriorityQueue<>(timeline);
		int n = 0;

		while (!userTimeline.isEmpty() && n < 10) {
			int[] topTweet = userTimeline.poll();

			// Check whether the tweet has been
			// posted by the user or one of the friends
			if (topTweet[2] == userId
				|| (friendsOfUser.containsKey(userId)
					&& friendsOfUser.get(userId).contains(
						topTweet[2]))) {
				ans.add(topTweet[1]);
				n++;
			}
		}
		return ans;
	}

	void follow(int followerId, int followeeId)
	{
		// Insert the followeeId in the map
		// corresponding to the followerId
		if (!friendsOfUser.containsKey(followerId)) {
			friendsOfUser.put(followerId, new HashSet<>());
		}
		friendsOfUser.get(followerId).add(followeeId);
	}

	void unfollow(int followerId, int followeeId)
	{
		// Remove the followeeId in the map
		// corresponding to the followerId
		if (friendsOfUser.containsKey(followerId)) {
			friendsOfUser.get(followerId)
				.remove(followeeId);
		}
	}
	
	public static void main(String[] args)
	{
		Twitter obj = new Twitter();
		int userId, tweetId;

		// Post tweet
		userId = 1;
		tweetId = 5;
		obj.postTweet(userId, tweetId);

		// Get newsfeed
		List<Integer> vec = obj.getNewsFeed(userId);
		for (Integer a : vec) {
			System.out.print(a + " ");
		}
		System.out.println();

		// Follow
		int follower, followee;
		follower = 1;
		followee = 2;
		obj.follow(follower, followee);

		// Post Tweet
		userId = 2;
		tweetId = 6;
		obj.postTweet(userId, tweetId);

		// Get newsfeed
		userId = 1;
		vec = obj.getNewsFeed(userId);
		for (Integer a : vec) {
			System.out.print(a + " ");
		}
		System.out.println();

		// Unfollow
		follower = 1;
		followee = 2;
		obj.unfollow(follower, followee);

		// Get newsfed
		vec = obj.getNewsFeed(userId);
		for (Integer a : vec) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}

class GFG {
	
}

// This code is contributed by lokeshmvs21.
