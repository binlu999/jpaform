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
		
		static public String parse(int v){
			for(QuestionType type: QuestionType.values()){
				if(type.getValue()==v){
					return type.name();
				}
			}
			return null;
		}
		
}
