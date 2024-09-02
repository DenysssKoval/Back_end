package de.ait.shop43.security;

import lombok.Getter;

import java.util.Objects;

@Getter
public class RefreshRequestDto {
    private String refreshToken;

    @Override
    public String toString() {
        return "RefreshRequest Token"  +
                 refreshToken;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefreshRequestDto that)) return false;

        return Objects.equals(refreshToken, that.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(refreshToken);
    }
}
