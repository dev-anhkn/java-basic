package org.example.structural_pattern.proxy_pattern;

class ProxyPatternDemo {
    // Subject interface
    interface Document {
        void display();
    }

    // Real Subject
    static class SecretDocument implements Document {
        private final String content;

        public SecretDocument(String content) {
            this.content = content;
        }

        @Override
        public void display() {
            System.out.println("Displaying secret document: " + content);
        }
    }

    // Proxy
    static class DocumentProxy implements Document {
        private SecretDocument secretDocument;
        private final String userRole;

        public DocumentProxy(String userRole) {
            this.userRole = userRole;
        }

        @Override
        public void display() {
            if ("ADMIN".equalsIgnoreCase(userRole)) {
                if (secretDocument == null) {
                    secretDocument = new SecretDocument("Top Secret Information!");
                }
                secretDocument.display();
            } else {
                System.out.println("Access Denied: You do not have permission to view this document.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Document doc1 = new DocumentProxy("USER");
        doc1.display(); // Output: Access Denied...

        Document doc2 = new DocumentProxy("ADMIN");
        doc2.display(); // Output: Displaying secret document...
    }
}
