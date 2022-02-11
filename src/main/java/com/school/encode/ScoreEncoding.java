package com.school.encode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScoreEncoding {
	
	//A+ ~ F학점 점수 변환기
	public List<SpellScore> spellScoreEncoding(List<Map<String,Object>> list) throws Exception{
		
		List<SpellScore> slist = new ArrayList<>();
		
		//A+~F까지의 점수로 변환하기
		for(int i = 0 ; i<list.size(); i++) {
			
			SpellScore sScore = new SpellScore();
			
			//원래점수 받아오기
			int mJava = Integer.parseInt(list.get(i).get("m_java").toString());
			int mSql = Integer.parseInt(list.get(i).get("m_sql").toString());
			int mSpring = Integer.parseInt(list.get(i).get("m_spring").toString());
			int mCss = Integer.parseInt(list.get(i).get("m_css").toString());
			int mjavaScript = Integer.parseInt(list.get(i).get("m_javascript").toString());
			Double mAverage = (mJava + mSql + mSpring + mCss + mjavaScript) / 5.0;
			
			//평균점수 인코딩
			if(95<mAverage) {
				sScore.setSAverage("A+");
			}else if(90<mAverage) {
				sScore.setSAverage("A");
			}else if(85<mAverage) {
				sScore.setSAverage("B+");
			}else if(80<mAverage) {
				sScore.setSAverage("B");
			}else if(75<mAverage) {
				sScore.setSAverage("C+");
			}else if(70<mAverage) {
				sScore.setSAverage("C");
			}else if(65<mAverage) {
				sScore.setSAverage("D");
			}else {
				sScore.setSAverage("F");
			}
			//자바 점수 인코딩
			if(95<mJava) {
				sScore.setSJava("A+");
			}else if(90<mJava) {
				sScore.setSJava("A");
			}else if(85<mJava) {
				sScore.setSJava("B+");
			}else if(80<mJava) {
				sScore.setSJava("B");
			}else if(75<mJava) {
				sScore.setSJava("C+");
			}else if(70<mJava) {
				sScore.setSJava("C");
			}else if(65<mJava) {
				sScore.setSJava("D");
			}else {
				sScore.setSJava("F");
			}
			//SQL 점수 인코딩
			if(95<mSql) {
				sScore.setSSql("A+");
			}else if(90<mSql) {
				sScore.setSSql("A");
			}else if(85<mSql) {
				sScore.setSSql("B+");
			}else if(80<mSql) {
				sScore.setSSql("B");
			}else if(75<mSql) {
				sScore.setSSql("C+");
			}else if(70<mSql) {
				sScore.setSSql("C");
			}else if(65<mSql) {
				sScore.setSSql("D");
			}else {
				sScore.setSSql("F");
			}
			
			//css 점수 인코딩
			if(95<mCss) {
				sScore.setSCss("A+");
			}else if(90<mCss) {
				sScore.setSCss("A");
			}else if(85<mCss) {
				sScore.setSCss("B+");
			}else if(80<mCss) {
				sScore.setSCss("B");
			}else if(75<mCss) {
				sScore.setSCss("C+");
			}else if(70<mCss) {
				sScore.setSCss("C");
			}else if(65<mCss) {
				sScore.setSCss("D");
			}else {
				sScore.setSCss("F");
			}
			
			//JavaScript 점수 인코딩
			if(95<mjavaScript) {
				sScore.setSJavaScript("A+");
			}else if(90<mjavaScript) {
				sScore.setSJavaScript("A");
			}else if(85<mjavaScript) {
				sScore.setSJavaScript("B+");
			}else if(80<mjavaScript) {
				sScore.setSJavaScript("B");
			}else if(75<mjavaScript) {
				sScore.setSJavaScript("C+");
			}else if(70<mjavaScript) {
				sScore.setSJavaScript("C");
			}else if(65<mjavaScript) {
				sScore.setSJavaScript("D");
			}else {
				sScore.setSJavaScript("F");
			}
			
			//Spring 점수 인코딩
			if(95<mSpring) {
				sScore.setSSpring("A+");
			}else if(90<mSpring) {
				sScore.setSSpring("A");
			}else if(85<mSpring) {
				sScore.setSSpring("B+");
			}else if(80<mSpring) {
				sScore.setSSpring("B");
			}else if(75<mSpring) {
				sScore.setSSpring("C+");
			}else if(70<mSpring) {
				sScore.setSSpring("C");
			}else if(65<mSpring) {
				sScore.setSSpring("D");
			}else {
				sScore.setSSpring("F");
			}
			
			slist.add(sScore);
		}
		return slist;
	}
	
	public List<NumberScore> numberScoreEncoding(List<SpellScore> slist) throws Exception{
		
		List<NumberScore> nlist = new ArrayList<>();
		//4.5점 만점 점수로 변환하기
		for(int i = 0; i<slist.size(); i++) {
			
			NumberScore numberScore = new NumberScore();
			
			String sAverage = slist.get(i).getSAverage();
			String sJava = slist.get(i).getSJava();
			String sJavaScript = slist.get(i).getSJavaScript();
			String sSql = slist.get(i).getSSpring();
			String sCss = slist.get(i).getSCss();
			String sSpring = slist.get(i).getSSpring();
			
			//4.5만점 평균값
			switch (sAverage) {
			case "A+":
				numberScore.setNAverage(4.5);
				break;
			case "A":
				numberScore.setNAverage(4.0);
				break;
			case "B+":
				numberScore.setNAverage(3.5);
				break;
			case "B":
				numberScore.setNAverage(3.0);
				break;
			case "C+":
				numberScore.setNAverage(2.5);
				break;
			case "C":
				numberScore.setNAverage(2.0);
				break;
			case "D":
				numberScore.setNAverage(1.5);
				break;
			case "F" :
				numberScore.setNAverage(1.0);
				break;
			}
			//자바점수 변환
			switch (sJava) {
			case "A+":
				numberScore.setNJava(4.5);
				break;
			case "A":
				numberScore.setNJava(4.0);
				break;
			case "B+":
				numberScore.setNJava(3.5);
				break;
			case "B":
				numberScore.setNJava(3.0);
				break;
			case "C+":
				numberScore.setNJava(2.5);
				break;
			case "C":
				numberScore.setNJava(2.0);
				break;
			case "D":
				numberScore.setNJava(1.5);
				break;
			case "F" :
				numberScore.setNJava(1.0);
				break;
			}
			
			//Sql
			switch (sSql) {
			case "A+":
				numberScore.setNSql(4.5);
				break;
			case "A":
				numberScore.setNSql(4.0);
				break;
			case "B+":
				numberScore.setNSql(3.5);
				break;
			case "B":
				numberScore.setNSql(3.0);
				break;
			case "C+":
				numberScore.setNSql(2.5);
				break;
			case "C":
				numberScore.setNSql(2.0);
				break;
			case "D":
				numberScore.setNSql(1.5);
				break;
			case "F" :
				numberScore.setNSql(1.0);
				break;
			}
			//CSS
			//자바점수 변환
			switch (sCss) {
			case "A+":
				numberScore.setNCss(4.5);
				break;
			case "A":
				numberScore.setNCss(4.0);
				break;
			case "B+":
				numberScore.setNCss(3.5);
				break;
			case "B":
				numberScore.setNCss(3.0);
				break;
			case "C+":
				numberScore.setNCss(2.5);
				break;
			case "C":
				numberScore.setNCss(2.0);
				break;
			case "D":
				numberScore.setNCss(1.5);
				break;
			case "F" :
				numberScore.setNCss(1.0);
				break;
			}
			//JavaScript
			switch (sJavaScript) {
			case "A+":
				numberScore.setNJavaScript(4.5);
				break;
			case "A":
				numberScore.setNJavaScript(4.0);
				break;
			case "B+":
				numberScore.setNJavaScript(3.5);
				break;
			case "B":
				numberScore.setNJavaScript(3.0);
				break;
			case "C+":
				numberScore.setNJavaScript(2.5);
				break;
			case "C":
				numberScore.setNJavaScript(2.0);
				break;
			case "D":
				numberScore.setNJavaScript(1.5);
				break;
			case "F" :
				numberScore.setNJavaScript(1.0);
				break;
			}
			//Spring
			switch (sSpring) {
			case "A+":
				numberScore.setNSpring(4.5);
				break;
			case "A":
				numberScore.setNSpring(4.0);
				break;
			case "B+":
				numberScore.setNSpring(3.5);
				break;
			case "B":
				numberScore.setNSpring(3.0);
				break;
			case "C+":
				numberScore.setNSpring(2.5);
				break;
			case "C":
				numberScore.setNSpring(2.0);
				break;
			case "D":
				numberScore.setNSpring(1.5);
				break;
			case "F" :
				numberScore.setNSpring(1.0);
				break;
			}
			
			nlist.add(numberScore);
		}
		return nlist;
	}
	
}
