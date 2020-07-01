package com.simple.dao;

import java.util.ArrayList;
import java.util.Arrays;

public class ex {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        boolean suc = true;
        
        for(int i = 0; i<participant.length; i++){
            for(int j = 0; j<completion.length; j++) {
            	if(participant[i].equals(completion[j])) {
            		completion[j] = null;
            		break;
            	}
            }
            if(suc) {
            	answer += participant[i];
            }
        }
        return answer;
    }
}

