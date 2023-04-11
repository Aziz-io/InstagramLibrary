package com.example.insta_test.responses.challenge;

import com.example.insta_test.responses.IGResponse;





public class ChallengeStateResponse extends IGResponse {
    private String step_name;
    private StepData step_data;

    public String getStep_name() {
        return step_name;
    }

    public void setStep_name(String step_name) {
        this.step_name = step_name;
    }

    public StepData getStep_data() {
        return step_data;
    }

    public void setStep_data(StepData step_data) {
        this.step_data = step_data;
    }

    public static class StepData {
        private String choice;
        private String email;

        public String getChoice() {
            return choice;
        }

        public void setChoice(String choice) {
            this.choice = choice;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
