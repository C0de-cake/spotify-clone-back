package fr.codecake.spotifyclone.infrastructure.service.dto;

public class StateBuilder<T, V> {
    private StatusNotification status;
    private T value;
    private V error;

    public StateBuilder<T, V> forError(V error) {
        this.error = error;
        this.status = StatusNotification.ERROR;
        return this;
    }

    public StateBuilder<T, V> forSuccess(T value) {
        this.value = value;
        this.status = StatusNotification.OK;
        return this;
    }

    public State<T, V> build() {
        return new State<>(this.status, this.value, this.error);
    }
}
