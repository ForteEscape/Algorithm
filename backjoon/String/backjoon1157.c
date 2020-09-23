#include<stdio.h>
#include<string.h>
#pragma warning(disable:4996)

char* changeUpper(char str[], int length);

int main() 
{
	char str[1000001];
	char* upperStr;
	int count[26] = { 0, };
	int max = 0;
	int overlapFlg = 0;
	int idx;
	int len;

	scanf("%s", str);

	len = strlen(str); // strlen is spend O(n)

	upperStr = changeUpper(str, len);
	len = strlen(str);

	for (int i = 0; i < len; i++) {
		int idx = (int)upperStr[i] - 65;
		count[idx]++;
	}

	for (int i = 0; i < 26; i++) {
		if (max < count[i]) {
			max = count[i];
			idx = i;
		}
	}

	for (int i = 0; i < 26; i++) {
		if (max == count[i]) {
			if (idx != i) {
				overlapFlg = 1;
				break;
			}
		}
	}

	if (overlapFlg == 1) {
		printf("?\n");
	}
	else {
		printf("%c\n", (char)(idx + 65));
	}
}

char* changeUpper(char str[], int length) {
	for (int i = 0; i < length; i++) {
		if (str[i] >= 'a' && str[i] <= 'z') {
			str[i] -= 32;
		}
	}

	char* string = strdup(str);

	return string;
}