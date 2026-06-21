class Twitter {

    Map<Integer, List<Tweet>> userTweetMap;
    Map<Integer, Set<Integer>> followMap;
    int k=0;

    public Twitter() {
        userTweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweetMap.computeIfAbsent(userId, a -> new ArrayList<>());
        userTweetMap.get(userId).add(new Tweet(tweetId, k++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        PriorityQueue<Node> maxHeap = 
            new PriorityQueue<>((a, b) -> Integer.compare(b.tweet.k, a.tweet.k));

        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if(followMap.containsKey(userId)){
            users.addAll(followMap.get(userId));
        }

        for(int user : users){
            
            List<Tweet> tweets = userTweetMap.get(user);

            if(tweets == null || tweets.size() == 0){
                continue;
            }

            int lastIdx = tweets.size() - 1;

            maxHeap.offer(new Node(user, lastIdx, tweets.get(lastIdx)));
        }  

        List<Integer> res = new ArrayList<>();

        while(!maxHeap.isEmpty() && res.size() < 10){
            Node node = maxHeap.poll();
            res.add(node.tweet.id);
            int prevIdx = node.tweetIdx - 1;

            if(prevIdx >= 0){
                Tweet prevTweet = userTweetMap.get(node.userId).get(prevIdx);
                maxHeap.offer(new Node(node.userId, prevIdx, prevTweet));
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        if(followMap.get(followerId) == null){
            Set<Integer> followSet = new HashSet<>();
            followMap.put(followerId, followSet);
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.get(followerId) != null){
            followMap.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}

class Tweet{
    int id;
    int k;

    Tweet(int id, int k){
        this.id = id;
        this.k = k;
    }
}

class Node{
    int userId;
    int tweetIdx;
    Tweet tweet;

    Node(int userId, int tweetIdx, Tweet tweet){
        this.userId = userId;
        this.tweetIdx = tweetIdx;
        this.tweet = tweet;
    }
}
