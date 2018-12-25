using airalgerieTest.BaseEntities;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Threading;

namespace AirlinesTestingApp.Pages
{
    public class TicketsPage
    {
        private IWebDriver driver;
        private const string Url = "https://airalgerie.dz/en/plan-your-trip/booking/booking-online/";
        By adultsAmountInput = By.Id("seladultsSelectBoxIt");
        By childrenButtonIncrement = By.Id("selchildrenSelectBoxIt");
        By infantButtonIncrement = By.Id("selinfantSelectBoxIt");

        public By errorFormMessage = By.XPath("//*[@id='error-message']/div[1]/ul/li");

        public string errorPassengersTooManyText = "More than 9 passengers...";
        public string errorChildrenWithoutAdultsText = "At least one adult per baby...";


        public IWebElement GetAdultsInput()
        {
            return driver.FindElement(adultsAmountInput);
        }

        public void ClickAdultsIncreasingButton()
        {
            driver.FindElement(adultsAmountInput).Click();
        }

        public void ClickChildrenIncreasingButton()
        {
            driver.FindElement(childrenButtonIncrement).Click();
        }

        public void InputInFieldData(int num, IWebElement element)
        {
            element.SendKeys(num.ToString());
        }

        public TicketsPage()
        {
            this.driver = Driver.GetDriverInstance();
        }

        public void OpenTicketsPage()
        {
            GoToUrl(Url);
        }

        public void GoToUrl(string url)
        {
            driver.Navigate().GoToUrl(url);
        }

        public IWebElement GetElement(By selector)
        {
            return driver.FindElement(selector);
        }

        public bool Exists(By selector)
        {
            return (driver.FindElements(selector).Count != 0);
        }
    }
}   