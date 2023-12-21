#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// ��������Ľڵ�
typedef struct HorizontalNode {
    int value;
    struct HorizontalNode* pre;
    struct HorizontalNode* next;
} HorizontalNode;

// ��������
typedef struct {
    HorizontalNode* head;
    HorizontalNode* tail;
    int length;
    int gg; // ˮƽλ�õ��ĸ�ֵ��Ӧ������������
} HorizontalList;

// ��������Ľڵ�
typedef struct VerticalNode {
    int value;
    struct VerticalNode* pre;
    struct VerticalNode* next;
    HorizontalList* horizontalList;
    int Hindex; // ����Node��������Node��λ��
    int Vindex; // ��������ĵڼ���Node
} VerticalNode;

// �����������
typedef struct {
    VerticalNode* head;
    VerticalNode* tail;
} VerticalList;

void initializeHorizontalList(HorizontalList* list) {
    list->head = NULL;
    list->tail = NULL;
    list->length = 0;
    list->gg = 0;
}

void insertHorizontalListTail(HorizontalList* list, int value) {
    // �����µ� HorizontalNode
    HorizontalNode* hNode = (HorizontalNode*)malloc(sizeof(HorizontalNode));
    hNode->value = value;
    hNode->pre = list->tail; // ����ǰһ���ڵ�Ϊ��ǰβ�ڵ�
    hNode->next = NULL;      // �½ڵ����һ���ڵ�Ϊ NULL

    // �������Ϊ�գ����½ڵ�ͬʱ��ͷ�ڵ��β�ڵ�
    if (list->head == NULL) {
        list->head = hNode;
        list->tail = hNode;
    }
    else {
        // �������Ϊ�գ�����뵽β��
        list->tail->next = hNode;
        hNode->pre = list->tail; // ����ǰһ���ڵ�
        list->tail = hNode;      // ����β�ڵ�
    }

    list->length++; // ����������
}

void deleteHorizontalListTail(HorizontalList* list) {
    if (list->head == NULL) {
        return;
    }
    if (list->head == list->tail) {
        free(list->head);
        list->head = NULL;
        list->tail = NULL;
    }
    else {
        HorizontalNode* preTail = list->tail->pre;
        free(list->tail);
        list->tail = preTail;
        list->tail->next = NULL;
    }
    list->length--;
}

int updateHorizontalList(HorizontalList* list, int index, int value) {
    if (index < 0) {
        return -2; // Invalid index
    }
    HorizontalNode* cur = list->head;
    while (cur != NULL && index > 1) {
        cur = cur->next;
        index--;
    }
    if (cur == NULL) {
        return -1; // Index out of range
    }
    cur->value = value;
    return 1; // Update successful
}

int move(HorizontalList* list, const char* direction, int step) {
    if (strcmp(direction, "left") == 0) {
        int index = list->gg + step;
        if (index >= list->length) {
            return -2; // Step too large
        }
        list->gg += step;
    }
    else if (strcmp(direction, "right") == 0) {
        int index = list->gg - step;
        if (index < 0) {
            return -2; // Step too large
        }
        list->gg -= step;
    }
    else {
        return -1; // Invalid direction
    }
    return 1; // Move successful
}



void initVerticalNode(VerticalNode* node, int val) {
    node->value = val;
    node->pre = NULL;
    node->next = NULL;
    node->horizontalList = NULL;
    node->Hindex = 0;
    node->Vindex = 0;
}

void insertVerticalListTail(VerticalList* list, int value) {
    VerticalNode* vNode = (VerticalNode*)malloc(sizeof(VerticalNode));
    vNode->value = value;
    vNode->pre = NULL;
    vNode->next = NULL;
    vNode->horizontalList = NULL;
    vNode->Hindex = 0;
    vNode->Vindex = 0;

    if (list->head == NULL) {
        list->head = vNode;
        list->tail = vNode;
        vNode->Vindex = 1;
    }
    else {
        vNode->pre = list->tail;
        list->tail->next = vNode;
        vNode->Vindex = list->tail->Vindex + 1;
        list->tail = vNode;
       

        if (vNode->Vindex > 0 && fmod(log(vNode->Vindex) / log(2), 1) == 0) {
            vNode->horizontalList = (HorizontalList*)malloc(sizeof(HorizontalList));
            vNode->horizontalList->head = NULL;
            vNode->horizontalList->tail = NULL;
            vNode->horizontalList->length = 0;
            vNode->horizontalList->gg = 0;
            insertHorizontalListTail(vNode->horizontalList, value);
        }
    }
}


void deleteVerticalListTail(VerticalList* list) {
    if (list->head == NULL) {
        return;
    }
    else if (list->head == list->tail) {
        free(list->head); // �ͷŽڵ�
        list->head = NULL;
        list->tail = NULL;
    }
    else {
        VerticalNode* preTail = list->tail->pre;
        free(list->tail); // �ͷŽڵ�
        preTail->next = NULL;
        list->tail = preTail;
    }
}

int updateVerticalList(VerticalList* list, int index, int value) {
    if (index < 0) {
        return -2; // Invalid index
    }
    VerticalNode* cur = list->head;
    while (cur != NULL && index > 1) {
        cur = cur->next;
        index--;
    }
    if (cur == NULL) {
        return -1; // Index out of range
    }
    cur->value = value;
    return 1; // Update successful
}

void printAllList(const VerticalList* list) {
    VerticalNode* cur = list->head;
    while (cur != NULL) {
        if (cur->horizontalList != NULL) {
            int index = cur->horizontalList->gg;
            HorizontalNode* ccur = cur->horizontalList->head;
            int count = 0;
            while (ccur != NULL) {
                if (ccur == cur->horizontalList->head && ccur == cur->horizontalList->tail && count == index) {
                    printf("%d<->", ccur->value);
                }
                else if (ccur == cur->horizontalList->head) {
                    if (count == index) {
                        printf("[%d#<->", ccur->value);
                    }
                    else {
                        printf("[%d<->", ccur->value);
                    }
                }
                else if (ccur == cur->horizontalList->tail) {
                    if (count == index) {
                        printf("%d#]<->", ccur->value);
                    }
                    else {
                        printf("%d]<->", ccur->value);
                    }
                }
                else {
                    if (count == index) {
                        printf("%d#<->", ccur->value);
                    }
                    else {
                        printf("%d<->", ccur->value);
                    }
                }
                count++;
                ccur = ccur->next;
            }
        }
        else {
            if (cur == list->tail) {
                printf("%d", cur->value);
            }
            else {
                printf("%d<->", cur->value);
            }
        }
        cur = cur->next;
    }
}

void insertShuiPing(VerticalList* list, int vIndex, int value) {
    VerticalNode* vcur = list->head;
    while (vcur != NULL && vIndex > 1) {
        vcur = vcur->next;
        vIndex--;
    }
    if (vcur == NULL) {
        return; // Index too large
    }
    if (vcur->horizontalList == NULL) {
        return; // No horizontal list
    }
    insertHorizontalListTail(vcur->horizontalList, value);
}


void deleteShuiPing(VerticalList* list, int vIndex) {
    VerticalNode* vcur = list->head;
    while (vcur != NULL && vIndex > 1) {
        vcur = vcur->next;
        vIndex--;
    }
    if (vcur == NULL) {
        return; // Index too large
    }
    if (vcur->horizontalList == NULL) {
        return; // No horizontal list
    }
    deleteHorizontalListTail(vcur->horizontalList);
}


void updateShuiPing(VerticalList* list, int vIndex, int HrIndex, int value) {
    VerticalNode* vcur = list->head;
    while (vcur != NULL && vIndex > 1) {
        vcur = vcur->next;
        vIndex--;
    }
    if (vcur == NULL) {
        return; // Index too large
    }
    if (vcur->horizontalList == NULL) {
        return; // No horizontal list
    }
    updateHorizontalList(vcur->horizontalList, HrIndex, value);
}

#include <string.h>

void moveShuiPing(VerticalList* list, int index, const char* direction, int step) {
    VerticalNode* vcur = list->head;
    while (vcur != NULL && index > 1) {
        vcur = vcur->next;
        index--;
    }
    if (vcur == NULL) {
        printf("Index too large\n");
        return;
    }
    if (vcur->horizontalList == NULL) {
        printf("No horizontal list\n");
        return;
    }
    if (step > vcur->horizontalList->length) {
        printf("Step too large\n");
        return;
    }

    int r = move(vcur->horizontalList, direction, step);
    if (r == 1) {
        HorizontalNode* hCur = vcur->horizontalList->head;
        int c = vcur->horizontalList->gg;
        while (hCur != NULL && c > 0) {
            hCur = hCur->next;
            c--;
        }
        vcur->value = hCur != NULL ? hCur->value : vcur->value;
        printf("Move successful\n");
    }
    else if (r == -1) {
        printf("Invalid direction\n");
    }
    else if (r == -2) {
        printf("Step too large\n");
    }
}

int ShuipingLength(VerticalList* list, int vIndex) {
    VerticalNode* vcur = list->head;
    while (vcur != NULL && vIndex > 1) {
        vcur = vcur->next;
        vIndex--;
    }
    if (vcur == NULL || vcur->horizontalList == NULL) {
        printf("û��ˮƽ����\n");
        return -1;
    }
    printf("ˮƽ����ĳ����ǣ�%d\n", vcur->horizontalList->length);
    return vcur->horizontalList->length;
}


int main() {
    VerticalList verticalList = { NULL, NULL };

    // ����β��
    insertVerticalListTail(&verticalList, 100);
    insertVerticalListTail(&verticalList, 200);
    insertVerticalListTail(&verticalList, 300);
    insertVerticalListTail(&verticalList, 400);
    insertVerticalListTail(&verticalList, 500);
    insertVerticalListTail(&verticalList, 600);
    insertVerticalListTail(&verticalList, 700);
    insertVerticalListTail(&verticalList, 800);
    insertVerticalListTail(&verticalList, 900);
    insertVerticalListTail(&verticalList, 1000);
    insertVerticalListTail(&verticalList, 1100);

    // ����β��
    insertShuiPing(&verticalList, 2, 1);
    insertShuiPing(&verticalList, 2, 2);
    insertShuiPing(&verticalList, 2, 3);
    insertShuiPing(&verticalList, 2, 4);
    insertShuiPing(&verticalList, 2, 5);
    insertShuiPing(&verticalList, 2, 6);
    insertShuiPing(&verticalList, 2, 7);
    insertShuiPing(&verticalList, 2, 8);
    insertShuiPing(&verticalList, 2, 9);
    insertShuiPing(&verticalList, 2, 10);
    insertShuiPing(&verticalList, 2, 11);

    insertShuiPing(&verticalList, 3, 1);
    insertShuiPing(&verticalList, 3, 2);


    insertShuiPing(&verticalList, 1, 1);
    insertShuiPing(&verticalList, 1, 2);

    insertShuiPing(&verticalList, 8, 1);
    insertShuiPing(&verticalList, 8, 2);
    insertShuiPing(&verticalList, 8, 3);
    insertShuiPing(&verticalList, 8, 4);
    insertShuiPing(&verticalList, 8, 5);
    insertShuiPing(&verticalList, 8, 6);
    insertShuiPing(&verticalList, 8, 7);
    insertShuiPing(&verticalList, 8, 8);
    insertShuiPing(&verticalList, 8, 9);
    insertShuiPing(&verticalList, 8, 10);
    insertShuiPing(&verticalList, 8, 11);

    printf("��ʼ�����ӡ\n");
    printAllList(&verticalList);
    printf("\n");


    printf("ˮƽ�ƶ�,��2��ˮƽ���������ƶ�5��\n");
    moveShuiPing(&verticalList, 2, "left", 5);
    printAllList(&verticalList);
    printf("\n");

    printf("ˮƽ�ƶ�,��8��ˮƽ���������ƶ�3��\n");
    moveShuiPing(&verticalList, 8, "right", 3);
    printAllList(&verticalList);
    printf("\n");

    printf("�޸�����,��8��ˮƽ����ĵ�5��Ԫ�ظ�Ϊ9999\n");
    updateShuiPing(&verticalList, 8, 5, 9999);
    printAllList(&verticalList);
    printf("\n");

    printf("����ɾ��\n");
    deleteVerticalListTail(&verticalList);
    printAllList(&verticalList);
    printf("\n");

    printf("����ɾ��\n");
    deleteShuiPing(&verticalList, 2);
    printAllList(&verticalList);
    printf("\n");

    printf("��2��ˮƽ����ĳ���\n");
    int length = ShuipingLength(&verticalList, 2);
    printf("����: %d\n", length);

    return 0;
}