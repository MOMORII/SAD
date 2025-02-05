**(1) UML component diagram for the 'Email Transport System':**

![image](https://github.com/user-attachments/assets/1bfb660a-ee3d-4313-b8d5-101b89afe2a5)
The image above was created using PlantUML.

**(2) Implementing an alternative transport mechanism via the Transportable interface:**

```
import java.io.*;
import java.net.*;

class RESTTransport implements Transportable {
    private String apiEndpoint;

    public RESTTransport(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    @Override
    public void send(Message msg) throws TransportException {
        try {
            URL url = new URL(apiEndpoint + "/sendEmail");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonPayload = "{ \"recipient\": \"" + msg.getRecipient() + 
                                 "\", \"subject\": \"" + msg.getSubject() + 
                                 "\", \"body\": \"" + msg.getBody() + "\" }";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonPayload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new TransportException("REST API failed with response code: " + responseCode);
            }

        } catch (IOException e) {
            throw new TransportException("Failed to connect to REST API");
        }
    }

    @Override
    public String getSmtpHost() { return null; }
    @Override
    public int getSmtpPort() { return -1; }
    @Override
    public void setSmtpHost(String smtpHost) { }
    @Override
    public void setSmtpPort(int smtpPort) { }
}
```
The code block above follows the 'Transportable' interface mechanisms, but it's able to send emails via REST.

**(3) How component design facilitates code reusability**

Code reusability is important as it reduces development time/cosy as well as improve reliability and quality. This particular component design facilitates code reuse, because the actual email transport logic is encapsulated to hide implementation details from the client. This is shown as the client only interacts with the Transportable interface.

In addition to this, the client is able to switch between SMTP (Transport) and REST (RESTTransport) without needing to modify existing code. This also means extra transport mechanisms can be added without breaking existing functionality in the same way. Thus, enabling code reusability if applied in different systems.
