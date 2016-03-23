package com.jpa.survey.entity.enums;

public enum QuestionType {
		TEXT(1),YESNO(2);
		
		private int value;
		QuestionType(int v){
			this.value=v;
		}
		
		public int getValue(){
			return value;
		}
	
		public static void main(String[] args){
			QuestionType a = QuestionType.valueOf("YESNO2");
			int v = a.getValue();
			v=+1;
		}
}
