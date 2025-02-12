package app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailGeneratorService {

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public String generateEmailReply(EmailRequest emailRequest) {
        // building prompt for the api
        String prompt = buildPrompt(emailRequest);

        // request

        Map<String, Object> requestBody = Map.of(
            "contents" , new Object[] {
                    Map.of( "parts" , new Object[]{
                            Map.of("text", prompt)
                    })
            }
        );

        // do request and get response



        //request response
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email response and please do not generate the subject line ");
        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            prompt.append("Use a ").append(emailRequest.getTone()).append("tone. ");
        }
        prompt.append("\n original email: \n").append(emailRequest.getEmailContent());

        return prompt.toString();
    }
}
