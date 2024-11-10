#Ejemplo de pantalla en pygame
import pygame

#configuracion de pygame
pygame.init() #Inicializamos pygame
screen = pygame.display.set_mode((800, 600)) #Seteamos las dimensiones de la pantalla
clock = pygame.time.Clock() #Creamos un reloj **No se bien para que es....
running = True

while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False


screen.fill("purple")
pygame.display.flip() #Actualiza la pantalla

clock.tick(60) #60 fotogramas por milisegundo
pygame.quit() #Cerramos