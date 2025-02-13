package design_voting_system;



import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCount; // Stores candidate -> votes
    private TreeMap<String, Integer> sortedResults; // Sorted results
    private LinkedHashMap<String, Integer> voteOrder; // Maintains order of votes

    public VotingSystem() {
        voteCount = new HashMap<>();
        sortedResults = new TreeMap<>();
        voteOrder = new LinkedHashMap<>();
    }

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        sortedResults.put(candidate, voteCount.get(candidate));
        voteOrder.put(candidate, voteCount.get(candidate));
    }

    // Get vote count for a specific candidate
    public int getVotes(String candidate) {
        return voteCount.getOrDefault(candidate, 0);
    }

    // Display results in order of votes
    public void displayVoteOrder() {
        System.out.println("Votes in order received: " + voteOrder);
    }

    // Display results sorted by candidate names
    public void displaySortedResults() {
        System.out.println("Sorted Results (Candidate Name): " + sortedResults);
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");

        votingSystem.displayVoteOrder();
        votingSystem.displaySortedResults();
    }
}
