package org.example.structural_pattern.proxy_pattern;

public class ProxySalaryRaiseDemo {
    // Real Subject interface
    interface SalaryService {
        void requestRaise(String employeeName, int amount);
    }

    // The actual business object
    static class EmployeeSalaryService implements SalaryService {
        @Override
        public void requestRaise(String employeeName, int amount) {
            System.out.println("🌟 Proposing a salary raise for " + employeeName + " by " + amount + " million VND.");
        }
    }

    // Proxy: controls access and logs activity
    static class SalaryServiceProxy implements SalaryService {
        private final EmployeeSalaryService realService = new EmployeeSalaryService();
        private final String userName;
        private final String role; // 'employee', 'manager', 'admin'

        public SalaryServiceProxy(String userName, String role) {
            this.userName = userName;
            this.role = role;
        }

        @Override
        public void requestRaise(String employeeName, int amount) {
            System.out.println("[Proxy] " + userName + " (" + role + ") is requesting a salary raise for " + employeeName);
            if ("manager".equalsIgnoreCase(role) || "admin".equalsIgnoreCase(role)) {
                realService.requestRaise(employeeName, amount);
            } else {
                System.out.println("❌ Access Denied: " + userName + " does not have permission to request a salary raise!");
            }
        }
    }

    // Demo runner
    public static void main(String[] args) {
        SalaryService employeeProxy = new SalaryServiceProxy("Alice", "employee");
        employeeProxy.requestRaise("Alice", 5);

        SalaryService managerProxy = new SalaryServiceProxy("Bob", "manager");
        managerProxy.requestRaise("David", 7);

        SalaryService adminProxy = new SalaryServiceProxy("Charlie", "admin");
        adminProxy.requestRaise("Eve", 10);
    }
}

