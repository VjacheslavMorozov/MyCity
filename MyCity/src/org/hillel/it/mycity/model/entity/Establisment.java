package org.hillel.it.mycity.model.entity;

public abstract class Establisment {
	private String nameOfEstablisment;
	private String adressOfEstablisment;
	private String telephoneOfEstablisment; //формат (0482) 34-56-15, можно добавить форматирование по
	private String descriptionOfEstablisment;
	private Comment[] comments;
	private int[] Assessment; //массив оценок от 1 - 10, из этого массива вычисляется средняя и показывается на странице заведения.
}
