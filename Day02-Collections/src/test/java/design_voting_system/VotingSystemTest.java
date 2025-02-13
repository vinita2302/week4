package design_voting_system;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VotingSystemTest {
    private VotingSystem votingSystem;

    @BeforeEach
    void setUp() {
        votingSystem = new VotingSystem();
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
    }

    @Test
    void testVoteCount() {
        assertEquals(2, votingSystem.getVotes("Alice"));
        assertEquals(1, votingSystem.getVotes("Bob"));
        assertEquals(1, votingSystem.getVotes("Charlie"));
    }

    @Test
    void testVoteForNewCandidate() {
        votingSystem.castVote("David");
        assertEquals(1, votingSystem.getVotes("David"));
    }

    @Test
    void testSortedResults() {
        votingSystem.displaySortedResults(); // Check if TreeMap sorts names
    }

    @Test
    void testVoteOrder() {
        votingSystem.displayVoteOrder(); // Check if LinkedHashMap maintains order
    }
}
