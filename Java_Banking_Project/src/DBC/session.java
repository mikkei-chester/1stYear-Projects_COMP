package DBC;



public class session {

    private static session instance = null;
    private long currentUserId = -1;

    private session() {}

    public static session getInstance() {
        if (instance == null) {
            instance = new session();
        }
        return instance;
    }

    public void login(long uid) {
        this.currentUserId = uid;
    }

    public void logout() {
        this.currentUserId = -1;
    }

    public long getCurrentUserId() {
        return currentUserId;
    }

    public boolean isLoggedIn() {
        return currentUserId != -1;
    }
}