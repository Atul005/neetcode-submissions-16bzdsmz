class Twitter {

    Map<Integer, List<Pair>> userTweetMap;
    Map<Integer, Set<Integer>> followMap;
    private int k = 0;

    public Twitter() {
        userTweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(userTweetMap.get(userId) == null){
            List<Pair> tweets = new ArrayList<>();
            userTweetMap.put(userId, tweets);
        }
        userTweetMap.get(userId).add(new Pair(tweetId, k++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Pair> tweets = new ArrayList<>();
         
        if(followMap.get(userId) != null){
            for(int followee : followMap.get(userId)){
                 if(userTweetMap.get(followee) != null){
                    tweets.addAll(userTweetMap.get(followee));
                }
            }
        }

        if(userTweetMap.get(userId) != null){
            tweets.addAll(userTweetMap.get(userId));
        }

        Collections.sort(tweets, (p1, p2) -> Long.compare(p2.k, p1.k));

        List<Integer> res = new ArrayList<Integer>();
        for(Pair p : tweets){
            res.add(p.id);
            if(res.size() == 10){
                break;
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        if(followMap.get(followerId) == null){
            Set<Integer> followList = new HashSet<>();
            followMap.put(followerId, followList);
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.get(followerId) != null){
            followMap.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}

class Pair{
    int id;
    int k;


    Pair(int id, int k){
        this.id = id;
        this.k = k;
    }
}
