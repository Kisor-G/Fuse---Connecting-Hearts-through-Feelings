package com.example.fuseapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button submitQueryButton;
    private EditText editTextUserQuery;
    private TextView textViewSuggestedText;

    private Map<String, String[]> predefinedQueries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        submitQueryButton = findViewById(R.id.buttonSubmitQuery);
        editTextUserQuery = findViewById(R.id.editTextUserQuery);
        textViewSuggestedText = findViewById(R.id.textViewSuggestedText);

        // Initialize predefined queries with sentiments and suggestions
        predefinedQueries = new HashMap<>();
        initializePredefinedQueries();

        // Submit query functionality
        submitQueryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userQuery = editTextUserQuery.getText().toString().trim();

                if (TextUtils.isEmpty(userQuery)) {
                    Toast.makeText(MainActivity.this, "Please enter a query", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Find sentiment and suggestion based on predefined queries
                String[] result = predefinedQueries.get(userQuery);
                if (result != null) {
                    String sentiment = result[0];
                    String suggestion = result[1];

                    // Display result
                    textViewSuggestedText.setText(String.format("Sentiment: %s\nSuggestion: %s", sentiment, suggestion));
                } else {
                    textViewSuggestedText.setText("No predefined suggestion available for this query.");
                }

                textViewSuggestedText.setVisibility(View.VISIBLE);
            }
        });


    }

    private void initializePredefinedQueries() {
        predefinedQueries.put("My partner seems upset with me. How can I fix this?", new String[]{"Negative", "Apologize sincerely and ask how you can make things better."});
        predefinedQueries.put("I want to celebrate our anniversary uniquely.", new String[]{"Positive", "Plan a memorable activity like stargazing or a surprise gift."});
        predefinedQueries.put("We had a fight last night, and now it's awkward.", new String[]{"Neutral", "Initiate a conversation and express your feelings calmly."});
        predefinedQueries.put("How can I make our relationship stronger?", new String[]{"Positive", "Engage in shared hobbies and practice open communication."});
        predefinedQueries.put("I'm worried my partner isn't happy anymore.", new String[]{"Negative", "Ask them how they're feeling and how you can support them."});
        predefinedQueries.put("My partner just achieved a big milestone!", new String[]{"Positive", "Congratulate them warmly and plan a small celebration together."});
        predefinedQueries.put("I don't feel valued in this relationship.", new String[]{"Negative", "Share your feelings with your partner and discuss ways to improve."});
        predefinedQueries.put("We haven't spent much time together lately.", new String[]{"Neutral", "Plan a date night or a day trip to reconnect."});
        predefinedQueries.put("What should I do if my partner is feeling anxious?", new String[]{"Positive", "Be a good listener and encourage them to take deep breaths."});
        predefinedQueries.put("I feel like I'm the only one putting in effort.", new String[]{"Negative", "Talk to your partner about sharing responsibilities and effort."});
        predefinedQueries.put("How can I show appreciation to my partner?", new String[]{"Positive", "Write a heartfelt note or surprise them with their favorite treat."});
        predefinedQueries.put("We argue about small things all the time.", new String[]{"Negative", "Try to identify triggers and approach disagreements calmly."});
        predefinedQueries.put("My partner and I just started dating. Any advice?", new String[]{"Positive", "Focus on understanding each other's likes, dislikes, and boundaries."});
        predefinedQueries.put("I feel insecure about my relationship sometimes.", new String[]{"Neutral", "Reflect on the root causes and share your concerns openly."});
        predefinedQueries.put("My partner is upset because I forgot an important date.", new String[]{"Negative", "Apologize sincerely and make plans to make up for it."});
        predefinedQueries.put("I want to make my partner's day extra special today.", new String[]{"Positive", "Plan a surprise activity or cook their favorite meal."});
        predefinedQueries.put("My partner doesn't listen to me when I talk.", new String[]{"Negative", "Share your feelings with them and ask for their attention calmly."});
        predefinedQueries.put("How do I apologize for a mistake I made?", new String[]{"Positive", "Admit your mistake, apologize sincerely, and express your willingness to improve."});
        predefinedQueries.put("I'm planning a romantic dinner for us.", new String[]{"Positive", "Choose a cozy setting and add a personal touch like a handwritten note."});
        predefinedQueries.put("We seem to be growing apart recently.", new String[]{"Neutral", "Spend more time together and revisit activities you both enjoy."});
        predefinedQueries.put("How can I comfort my partner after a stressful day?", new String[]{"Positive", "Offer a listening ear and suggest relaxing activities like a walk."});
        predefinedQueries.put("I feel like I'm always being criticized.", new String[]{"Negative", "Discuss how the criticism makes you feel and set mutual boundaries."});
        predefinedQueries.put("We had the best day ever yesterday!", new String[]{"Positive", "Express gratitude for the time together and plan more such days."});
        predefinedQueries.put("My partner has been distant lately. What should I do?", new String[]{"Neutral", "Ask if everything is okay and offer your support."});
        predefinedQueries.put("How can we make weekends more fun?", new String[]{"Positive", "Explore new activities like hiking, cooking together, or movie nights."});
        predefinedQueries.put("I feel jealous of my partner's close friend.", new String[]{"Negative", "Acknowledge your feelings, communicate them, and build trust."});
        predefinedQueries.put("How can I plan a surprise trip for my partner?", new String[]{"Positive", "Research places they love and arrange everything secretly for a surprise."});
        predefinedQueries.put("My partner doesn’t appreciate my efforts.", new String[]{"Negative", "Share your feelings openly and ask how you both can align expectations."});
        predefinedQueries.put("We're planning to move in together. Any advice?", new String[]{"Positive", "Discuss expectations, boundaries, and responsibilities beforehand."});
        predefinedQueries.put("My partner doesn’t seem interested in our conversations.", new String[]{"Neutral", "Ask if something is on their mind and work on active listening."});
    }
}
