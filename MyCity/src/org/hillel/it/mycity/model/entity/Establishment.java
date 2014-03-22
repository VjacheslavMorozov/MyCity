package org.hillel.it.mycity.model.entity;

import java.util.List;

public abstract class Establishment extends BaseEntity{
	protected String nameOfEstablishment;
	protected String addressOfEstablishment;
	protected String telephoneOfEstablishment; //формат (0482) 34-56-15, можно добавить форматирование по
	protected String descriptionOfEstablishment;
	protected Comment comment;
	//массив оценок от 1 - 10, из этого массива вычисляется средняя и показывается на странице заведения.
	protected List<Integer> assessment;
	protected double averageAssessment;
	protected int sumOfAssessment;
}
