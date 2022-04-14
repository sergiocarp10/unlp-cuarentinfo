%% Limpiamos variables y figuras anteriores
clear
clc

%% Declaraci�n de constantes
SAT = [2 8 16];       % N�meros de los sat�lites a comparar

%% Cargamos la se�al inc�gnita (s)
load('senial_incognita.mat');

%% Agregamos ruido
xincn = s+7*randn(size(s));

%% Comparamos la se�al con ruido con la correspondiente a cada sat�lite
m = (-2557:1:2557);

for k = 1 : length(SAT)
    % Generaci�n del c�digo de sat�lite (de 5 periodos)
    x = cacode(SAT(k));
    x = repmat(x,1,5);
    % C�lculo de la intercorrelaci�n con la se�al inc�gnita
    r = correlfft(x, xincn);
    % Se genera la imagen del resultado para el sat�lite actual
    figure; stem(m, fftshift(r),'.'); title(strcat('Intercorrelaci�n para Sat�lite:',num2str(SAT(k))));
    xlabel('m'); ylabel('r�_x_s[m]');
end