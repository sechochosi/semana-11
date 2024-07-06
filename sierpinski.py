import matplotlib.pyplot as plt
import numpy as np

def draw_triangle(ax, points, color='black'):
    """Dibuja un triángulo en el objeto Axes de matplotlib."""
    triangle = plt.Polygon(points, edgecolor=color, fill=None)
    ax.add_patch(triangle)

def draw_sierpinski(ax, points, level):
    """Función recursiva para dibujar el Triángulo de Sierpinski."""
    if level == 0:
        draw_triangle(ax, points)
    else:
        p1 = (points[0] + points[1]) / 2
        p2 = (points[1] + points[2]) / 2
        p3 = (points[2] + points[0]) / 2
        
        draw_sierpinski(ax, [points[0], p1, p3], level - 1)
        draw_sierpinski(ax, [p1, points[1], p2], level - 1)
        draw_sierpinski(ax, [p3, p2, points[2]], level - 1)

fig, ax = plt.subplots()
ax.set_aspect('equal')
ax.axis('off')

points = np.array([[0, 0], [1, 0], [0.5, np.sqrt(3) / 2]])

level = 5

draw_sierpinski(ax, points, level)

plt.show()
