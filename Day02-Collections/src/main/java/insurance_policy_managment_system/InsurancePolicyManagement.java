package insurance_policy_managment_system;

import java.util.*;
import java.time.*;

public class InsurancePolicyManagement {
    public Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    public Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        hashSet.forEach(System.out::println);
    }

    public void displayPoliciesExpiringSoon() {
        LocalDate now = LocalDate.now();
        LocalDate threshold = now.plusDays(30);
        System.out.println("Policies Expiring Soon:");
        treeSet.stream()
                .filter(p -> p.getExpiryDate().isBefore(threshold))
                .forEach(System.out::println);
    }

    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("Policies with Coverage Type: " + coverageType);
        hashSet.stream()
                .filter(p -> p.getCoverageType().equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }

    public void displayDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        for (Policy policy : hashSet) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }
        System.out.println("Duplicate Policies:");
        policyCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println("Policy Number: " + entry.getKey() + ", Count: " + entry.getValue()));
    }

    public void comparePerformance() {
        System.out.println("Performance Comparison:");

        List<Policy> policies = new ArrayList<>(hashSet);
        long start, end;

        // HashSet Performance
        start = System.nanoTime();
        policies.forEach(hashSet::contains);
        end = System.nanoTime();
        System.out.println("HashSet lookup time: " + (end - start) + " ns");

        // LinkedHashSet Performance
        start = System.nanoTime();
        policies.forEach(linkedHashSet::contains);
        end = System.nanoTime();
        System.out.println("LinkedHashSet lookup time: " + (end - start) + " ns");

        // TreeSet Performance
        start = System.nanoTime();
        policies.forEach(treeSet::contains);
        end = System.nanoTime();
        System.out.println("TreeSet lookup time: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();
        manager.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(20), "Health", 500.0));
        manager.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 600.0));
        manager.addPolicy(new Policy("P003", "Charlie", LocalDate.now().plusDays(10), "Home", 700.0));
        manager.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(20), "Health", 500.0)); // Duplicate

        manager.displayAllPolicies();
        manager.displayPoliciesExpiringSoon();
        manager.displayPoliciesByCoverage("Health");
        manager.displayDuplicatePolicies();
        manager.comparePerformance();
    }
}
