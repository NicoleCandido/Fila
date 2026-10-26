/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fila;

/**
 *
 * @author nicole57193517
 */
public class Fila {
    private int frente, tras, tamanho;
    private int capacidade;
    private int[] elementos;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        elementos = new int[capacidade];
        frente = 0;
        tras = -1;
        tamanho = 0;
    }

    // Método para adicionar um elemento no final da fila
    public void enqueue(int elemento) {
        if (isFull()) {
            System.out.println("Fila cheia! Não foi possível adicionar " + elemento + ".");
            return;
        }
        tras = (tras + 1) % capacidade;  // Incremento circular: volta ao início do vetor
        elementos[tras] = elemento;
        tamanho++;
    }

    // Método para remover o elemento da frente da fila
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("A fila está vazia!");
            return -1; // Retorna -1 caso a fila esteja vazia
        }
        int removido = elementos[frente];
        frente = (frente + 1) % capacidade; // Incremento circular
        tamanho--;
        return removido;
    }

    // Método para verificar se a fila está vazia
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Método para verificar se a fila está cheia
    public boolean isFull() {
        return tamanho == capacidade;
    }

    // Método para olhar o elemento da frente da fila (sem removê-lo)
    public int peek() {
        if (isEmpty()) {
            System.out.println("A fila está vazia!");
            return -1; // Retorna -1 caso a fila esteja vazia
        }
        return elementos[frente];
    }

    // Método para exibir os elementos da fila, da frente para o final
    public void exibir() {
        if (isEmpty()) {
            System.out.println("Fila: [ ]");
            return;
        }
        StringBuilder texto = new StringBuilder("Fila: [ ");
        for (int i = 0; i < tamanho; i++) {
            texto.append(elementos[(frente + i) % capacidade]).append(" "); // Acesso circular
        }
        texto.append("]");
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Fila fila = new Fila(5);

        System.out.println("=== Adicionando elementos ===");
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        fila.exibir();

        System.out.println("\n=== Consultando a frente ===");
        System.out.println("Elemento da frente (peek): " + fila.peek());

        System.out.println("\n=== Removendo um elemento ===");
        System.out.println("Removido da fila: " + fila.dequeue());
        fila.exibir();

        System.out.println("\n=== Enchendo a fila (comportamento circular) ===");
        fila.enqueue(40);
        fila.enqueue(50);
        fila.enqueue(60);   // ocupa a posição liberada no início do vetor
        fila.exibir();
        fila.enqueue(70);   // fila cheia

        System.out.println("\n=== Esvaziando a fila ===");
        while (!fila.isEmpty()) {
            System.out.println("Removido: " + fila.dequeue());
        }
        fila.exibir();
        fila.dequeue();     // fila vazia
    }
}