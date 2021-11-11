int a = 4, b = 12, c = 3;
boolean d = false;
int result = 4;
if(a > b || b % c == 0) {
	if(d == true) {
		result = result + 1;
	}
	else {
		result = result - 1;
	}
	result = result * 2;
}

if(d == false && a == b/c) {
	result = result + 1;
	a = a + 1;
	d = true;
}

if(d == false && a == b/c) {
	result = result + 2;
}
else {
	b = b - 2;
	c = c - 1;
	d = false;
}

if(d == false && a == b/c) {
	result = result + 3;
}
