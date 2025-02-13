package insurance_policy_management_system_map;
import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagement {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<InsurancePolicy>> sortedPolicyMap = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPolicyMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<InsurancePolicy> getPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        List<InsurancePolicy> expiringSoon = new ArrayList<>();

        sortedPolicyMap.subMap(today, threshold).values().forEach(expiringSoon::addAll);
        return expiringSoon;
    }

    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<InsurancePolicy>>> iterator = sortedPolicyMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<InsurancePolicy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (InsurancePolicy policy : entry.getValue()) {
                    policyMap.remove(policy.getPolicyNumber());
                    orderedPolicyMap.remove(policy.getPolicyNumber());
                }
                iterator.remove();
            } else {
                break; // Since TreeMap is sorted, no need to check further
            }
        }
    }

    public void displayAllPolicies() {
        System.out.println("All Policies:");
        for (InsurancePolicy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        manager.addPolicy(new InsurancePolicy("P001", "Alice", LocalDate.now().plusDays(20), "Health", 500.0));
        manager.addPolicy(new InsurancePolicy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 600.0));
        manager.addPolicy(new InsurancePolicy("P003", "Charlie", LocalDate.now().plusDays(10), "Home", 700.0));
        manager.addPolicy(new InsurancePolicy("P004", "David", LocalDate.now().minusDays(5), "Health", 550.0));

        // Display all policies
        manager.displayAllPolicies();

        // Retrieve a specific policy
        System.out.println("\nPolicy Lookup (P001): " + manager.getPolicyByNumber("P001"));

        // Get expiring soon policies
        System.out.println("\nPolicies expiring in the next 30 days:");
        manager.getPoliciesExpiringSoon().forEach(System.out::println);

        // Get policies by policyholder
        System.out.println("\nPolicies owned by Alice:");
        manager.getPoliciesByHolder("Alice").forEach(System.out::println);

        // Remove expired policies
        System.out.println("\nRemoving expired policies...");
        manager.removeExpiredPolicies();
        manager.displayAllPolicies();
    }
}

