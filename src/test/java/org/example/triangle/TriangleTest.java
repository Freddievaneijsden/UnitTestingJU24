package org.example.triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    static Stream<Arguments> pointProvider() {
        return Stream.of(
                Arguments.of(new Point(0, 0), new Point(1, 1), new Point(2, 0)),
                Arguments.of(new Point(1, 2), new Point(3, 5), new Point(5, 4)),
                Arguments.of(new Point(1, 1), new Point(4, 5), new Point(6, 1)),
                Arguments.of(new Point(2, 2), new Point(4, 5), new Point(5, 1)),
                Arguments.of(new Point(3, 1), new Point(6, 3), new Point(5, 7)) );
    }

    @ParameterizedTest
    @MethodSource ("pointProvider")
    @DisplayName("CreateTriangleWithPointArrayConstructor")
    void createTriangleWithPointArrayConstructor(Point p1, Point p2, Point p3) {
        Point[] points = {p1, p2, p3};
        Triangle triangle = new Triangle(points);
        assertNotNull(triangle);
    }

    @Test
    @DisplayName("CreateTriangleWithDoubleArrayConstructor")
    void createTriangleWithDoubleArrayConstructor() {
        double d1 = 3.0;
        double d2 = 4.0;
        double d3 = 5.0;
        double[] doubles = {d1, d2, d3};
        Triangle triangle = new Triangle(doubles);
        assertThat(triangle.sides).containsExactly(3.0, 4.0, 5.0);
    }

    @Test
    @DisplayName("CreateTriangleWithDoubleConstructor")
    void createTriangleWithDoubleConstructor() {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertNotNull(triangle);
    }

    @Test
    @DisplayName("TestIfTriangleIsScalene")
    void testIfTriangleIsScalene() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(2, 6);
        Triangle triangle = new Triangle(p1, p2, p3);
        assertTrue(triangle.isScalene());
    }

    @Test
    @DisplayName("TestIfTriangleIsEquilateral")
    void testIfTriangleIsEquilateral() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(2, 2);
        Triangle triangle = new Triangle(p1, p2, p3);
        assertTrue(triangle.isEquilateral());
    }

    @Test
    @DisplayName("TestIfTriangleIsIsosceles")
    void testIfTriangleIsIsosceles() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(4, 2);
        Triangle triangle = new Triangle(p1, p2, p3);
        assertTrue(triangle.isIsosceles());
    }

    @Test
    @DisplayName("TestThatTriangleNotIsIsosceles")
    void testThatTriangleNotIsIsosceles() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 3);
        Point p3 = new Point(4, 2);
        Triangle triangle = new Triangle(p1, p2, p3);
        assertFalse(triangle.isIsosceles());
    }

    @Test
    @DisplayName("TestThatTriangleNotIsEquilateral")
    void testThatTriangleNotIsEquilateral() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(2, 3);
        Triangle triangle = new Triangle(p1, p2, p3);
        assertFalse(triangle.isEquilateral());
    }

    @Test
    @DisplayName("TestThatTriangleNotIsScalene")
    void testThatTriangleNotIsScalene() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(2, 5);
        Triangle triangle = new Triangle(p1, p2, p3);
        assertFalse(triangle.isScalene());
    }
}