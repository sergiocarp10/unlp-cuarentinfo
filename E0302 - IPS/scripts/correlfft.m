%% Esta funci�n calcula la correlaci�n circular entre 2 se�ales: x e y.          
function r = correlfft(x, y)

%% Se refleja circularmente la se�al y
y_2 = [y(1) y(end:-1:2)];

%% Se aplica el conjugado a cada valor de la se�al reflejada
y_2 = conj(y_2);

%% Se calcula la correlaci�n circular
Tx = fft(x);                % TDF de "x"
Ty = fft(y_2);              % TDF de "y" conjugada y reflejada circ.
r = real(ifft(Tx.*Ty));     % Se descarta la componente imaginaria

%% [EOF]