package api.requests;

public class CorrectResponse {
    private String result_url;

    public CorrectResponse() {
    }

    public CorrectResponse(String result_url) {
        this.result_url = result_url;
    }

    public String getResult_url() {
        return result_url;
    }
}
