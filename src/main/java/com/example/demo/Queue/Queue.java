package com.example.demo.Queue;

//TODO parametrizar
public class Queue {
	Node frente;
	Node atras;

	public Queue()
	{
		this.frente = this.atras = null;
	}

	
	void enqueue(int key)
	{
		Node temp = new Node(key);
		if (this.frente == null) {
			this.frente = this.atras = temp;
			return;
		}
		this.atras.next = temp;
		this.atras = temp;
	}

	
	void dequeue()
	{
		if (this.frente == null)
			return;
		
		Node temp = this.frente;
		this.frente = this.frente.next;

		
		if (this.frente == null)
			this.atras = null;
	}
} 
  
