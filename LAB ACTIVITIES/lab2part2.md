Code Analysis
1- Modular and Cohesive Properties of the Transport Class
The Transport class exhibits the following modular and cohesive properties:

Modularity:

The class follows modular design principles by implementing the Transportable interface, allowing flexibility in replacing the email transport mechanism.
It separates concerns by defining private methods (sendMessage and smtpErrorExists) for specific tasks, making it easier to maintain and test.
Cohesion:

The class focuses on handling SMTP-based email transport, meaning all methods are closely related to the same functionality (sending emails).
Each method within Transport performs a distinct subtask, contributing to the overall goal of sending an email.
2- Purpose of Each Method in the Transport Class
send(Message msg):

Establishes a connection to the SMTP server using a socket.
Handles initial communication and checks for connection errors.
Calls sendMessage(msg, in, out) to send the email message.
sendMessage(Message msg, BufferedReader in, PrintWriter out):

Handles the email transmission process after a successful connection.
Implements the SMTP protocol steps (e.g., HELO, MAIL FROM, RCPT TO, DATA).
Ensures that each step is completed successfully.
smtpErrorExists(BufferedReader in, String errCode):

Checks if an SMTP error response exists in the server’s reply.
Helps detect communication failures based on expected SMTP response codes (e.g., "220" for a successful connection).
3- How Does the send() Method Handle Potential Errors During Email Transmission?
Socket Handling:

If the socket connection to the SMTP server fails, it throws a TransportException.
SMTP Response Handling:

It reads the initial response from the SMTP server and checks for errors.
If the expected "220" response is not received, it throws a TransportException.
Exception Handling:

Uses a try-catch block to catch IOException and rethrows it as a TransportException.
Ensures that error conditions are handled properly without crashing the system.
