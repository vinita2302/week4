package insurance_policy_managment_system;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InsurancePolicyManagementTest {
    private InsurancePolicyManagement manager;

    @BeforeEach
    void setUp() {
        manager = new InsurancePolicyManagement();
    }

    @Test
    void testAddAndRetrievePolicies() {
        Policy policy1 = new Policy("P001", "Alice", LocalDate.now().plusDays(20), "Health", 500.0);
        Policy policy2 = new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 600.0);

        manager.addPolicy(policy1);
        manager.addPolicy(policy2);

        // Verify policies are stored
        assertEquals(2, manager.hashSet.size(), "Policies should be added correctly.");
    }

    @Test
    void testDisplayPoliciesExpiringSoon() {
        Policy policy1 = new Policy("P001", "Alice", LocalDate.now().plusDays(20), "Health", 500.0);
        Policy policy2 = new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 600.0);

        manager.addPolicy(policy1);
        manager.addPolicy(policy2);

        // Capture expiring policies
        List<Policy> expiringSoon = new ArrayList<>();
        manager.treeSet.stream()
                .filter(p -> p.getExpiryDate().isBefore(LocalDate.now().plusDays(30)))
                .forEach(expiringSoon::add);

        assertTrue(expiringSoon.contains(policy1), "Policy P001 should be expiring soon.");
        assertFalse(expiringSoon.contains(policy2), "Policy P002 should not be expiring soon.");
    }

    @Test
    void testDisplayDuplicatePolicies() {
        Policy policy1 = new Policy("P001", "Alice", LocalDate.now().plusDays(20), "Health", 500.0);
        Policy duplicatePolicy = new Policy("P001", "Alice", LocalDate.now().plusDays(20), "Health", 500.0);

        manager.addPolicy(policy1);
        manager.addPolicy(duplicatePolicy);

        // Verify duplicates count logic
        Map<String, Integer> policyCount = new HashMap<>();
        for (Policy policy : manager.hashSet) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }

        assertTrue(policyCount.get("P001") == 1, "Duplicate should not be added in HashSet.");
    }
}
