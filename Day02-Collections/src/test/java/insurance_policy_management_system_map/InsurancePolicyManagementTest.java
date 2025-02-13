package insurance_policy_management_system_map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class InsurancePolicyManagementTest {
    private InsurancePolicyManagement manager;

    @BeforeEach
    void setUp() {
        manager = new InsurancePolicyManagement();
        manager.addPolicy(new InsurancePolicy("P001", "Alice", LocalDate.now().plusDays(20), "Health", 500.0));
        manager.addPolicy(new InsurancePolicy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 600.0));
        manager.addPolicy(new InsurancePolicy("P003", "Charlie", LocalDate.now().plusDays(10), "Home", 700.0));
        manager.addPolicy(new InsurancePolicy("P004", "David", LocalDate.now().minusDays(5), "Health", 550.0)); // Expired policy
    }

    @Test
    void testGetPolicyByNumber() {
        InsurancePolicy policy = manager.getPolicyByNumber("P001");
        assertNotNull(policy);
        assertEquals("Alice", policy.getPolicyHolderName());
        assertEquals("Health", policy.getCoverageType());
    }

    @Test
    void testGetPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringSoon = manager.getPoliciesExpiringSoon();
        assertFalse(expiringSoon.isEmpty());
        assertEquals(2, expiringSoon.size()); // P001 & P003 should be expiring soon
    }

    @Test
    void testGetPoliciesByHolder() {
        List<InsurancePolicy> alicePolicies = manager.getPoliciesByHolder("Alice");
        assertEquals(1, alicePolicies.size());
        assertEquals("P001", alicePolicies.get(0).getPolicyNumber());
    }

    @Test
    void testRemoveExpiredPolicies() {
        manager.removeExpiredPolicies();
        assertNull(manager.getPolicyByNumber("P004")); // P004 should be removed
    }

    @Test
    void testAddPolicy() {
        manager.addPolicy(new InsurancePolicy("P005", "Eve", LocalDate.now().plusDays(50), "Life", 800.0));
        InsurancePolicy newPolicy = manager.getPolicyByNumber("P005");
        assertNotNull(newPolicy);
        assertEquals("Life", newPolicy.getCoverageType());
    }
}
