package com.roofflex.limitsservice.model;


/**
 * Limits model
 *
 * @param min minimum limit
 * @param max maximum limit
 */
public record Limits(int min, int max) {

    public static Limits limits(int min, int max) {
        return new Limits(min, max);
    }
}
