import pygame
from constantes import *


class Personaje:
    def __init__(self, x, y):
        self.image = pygame.image.load(f'{ASSETS_PATH}/imagenes/nave1.jfif')
        self.image = pygame.transform.scale(self.image, (95, 95))
        self.shape = self.image.get_rect(center=(x, y))
        self.lasers = []
        self.energia = 100 #Barra de energia

    def mover(self, dx, dy):
        self.shape.x += dx
        self.shape.y += dy

    def lanzar_laser(self):
        laser = Laser(self.shape.centerx, self.shape.top)
        self.lasers.append(laser)