#include<iostream>
#include<stack>
#include<cstring>
using namespace std;

int main()
{
	int testCase;
	bool isInvail = false;
	char pString[51];

	cin >> testCase;

	for (int i = 0; i < testCase; i++) {
		isInvail = false;
		stack<char>myStack;
		cin >> pString;

		for (int j = 0; j < strlen(pString); j++) {
			if (pString[j] == '(') {
				myStack.push(pString[i]);
			}
			else if (pString[j] == ')') {
				if (myStack.empty()) {
					isInvail = true;
					break;
				}

				myStack.pop();
			}
		}
		if (isInvail) {
			cout << "NO" << endl;
			continue;
		}

		if (!myStack.empty()) {
			cout << "NO" << endl;
		}
		else {
			cout << "YES" << endl;
		}
	}
}