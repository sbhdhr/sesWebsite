import requests
import json
import sys

url = "https://ses-project-bitsme.herokuapp.com/api/"


def get_all_alerts():
    res = requests.get(url + "alerttype/all")
    text = res.text
    alert_list = json.loads(text)
    # print(type(alert_list))
    for i, v in enumerate(alert_list):
        t = (i + 1, v["desc"])
        alert_list[i] = t
    return alert_list


def send_alert(n):
    res = requests.post(url + "alert/" + str(n))
    return res.text


if __name__ == "__main__":
    alert_list = get_all_alerts()
    while True:
        print("\n------- Send Alert -------")
        print("r. Refresh types of alerts to send.")
        print("q. Exit")
        for i, j in alert_list:
            print("{}. {}".format(i, j))
        print()
        try:
            c = input("Enter your choice: ")
            if c == 'r' or c == 'R':
                alert_list = get_all_alerts()
                print("Alerts refreshed !!")
            elif c == 'q' or c == 'Q':
                break
            else:
                c = int(c)
                print(send_alert(c))
        except:
            print("Error!", sys.exc_info()[0], " occured.")
