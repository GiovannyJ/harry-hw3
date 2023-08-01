import java.util.ArrayList;

public class RequestQueue extends ArrayList<Request> {
    public void enqueue(Request request) {
        this.add(request);
    }

    public Request dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        return this.remove(0);
    }
}