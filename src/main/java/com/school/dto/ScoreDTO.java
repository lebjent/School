package com.school.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Alias("ScoreDTO")
@Data
public class ScoreDTO {
	
	private int scoreIdx;
	private int mJava;
	private int mSql;
	private int mJavaScript;
	private int mSpring;
	private int mCss;
	private int studentIdx;
	
}
