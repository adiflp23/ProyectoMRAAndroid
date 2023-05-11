package com.example.mesonrafaelalberti;

public class cartaMRA {
        private String categoria;
        private String nombre;
        private float precio;

        public cartaMRA(String categoria, String nombre, float precio){
            this.categoria = categoria;
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getCategoria() {
            return categoria;
        }

        public String getNombre() {
            return nombre;
        }

        public float getPrecio() {
            return precio;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setPrecio(float precio) {
            this.precio = precio;
        }
}
