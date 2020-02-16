package com.example.ssis_tracker.repository.agregarcomentarios;

import com.google.gson.JsonArray;

public interface ActivityComentarRepository {
    void AgregarComentario(JsonArray jsonComentario);
}
