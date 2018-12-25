using airalgerieTest.BaseEntities;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Threading;

namespace AirlinesTestingApp.Pages
{
    public class HomePage
    {
        private IWebDriver driver;
        private const string Url = "https://airalgerie.dz/";
        By advertisementCross = By.ClassName("close-cookies");
        By openBooking = By.ClassName("t-booking-tab.-new-booking.js-booking-tab.-active");
        By oneWayTicketCheckbox = By.Id("new-booking-2-way");
        By leavingTicketDate = By.Id("selddate1");
        By returnTicketDate = By.Id("seladate1");
        By departure = By.Id("seldcity1");
        By arrival = By.Id("selacity1");
        By bookingFormSubmitButton = By.ClassName("simple-btn.js-submit-booking");

        private void SelectDeparture()
        {
            var placeToLeave = new SelectElement(driver.FindElement(departure));
            placeToLeave.SelectByIndex(1);//Because "zero" value is default
        }

        private void ChooseValueOfSelectTag(By selector, int index)
        {
            var selectElement = new SelectElement(driver.FindElement(selector));
            selectElement.SelectByIndex(index);//Because "zero" value is default
        }

        public HomePage()
        {
            this.driver = Driver.GetDriverInstance();
        }   

        public void OpenHomePage()
        {
            GoToUrl(Url);
        }

        public void GoToUrl(string url)
        {
            driver.Navigate().GoToUrl(url);
        }

        public void CloseAds()
        {
            driver.FindElement(advertisementCross).Click();
            Thread.Sleep(1000);
        }

        public void SelectOneWayTicket()
        {
            driver.FindElement(openBooking).Click();
            Thread.Sleep(1000); 
            driver.FindElement(oneWayTicketCheckbox).Click();
        }

        public IWebElement GetReturnTicketDate()
        {
            return driver.FindElement(returnTicketDate);
        }

        public IWebElement GetLeavingTicketDate()
        {
            return driver.FindElement(leavingTicketDate);
        }

        public IWebElement GetReturnTicketProximity()
        {
            return driver.FindElement(returnTicketProximity);
        }

        public void FillInBookingForm()
        {
            ChooseValueOfSelectTag(departure, 1);
            ChooseValueOfSelectTag(arrival, 12);

            SetDateTime(driver.FindElement(leavingTicketDate), DateTime.Now.ToString("dd'/'MM'/'yyyy"));
            SetDateTime(GetReturnTicketDate(), DateTime.Now.ToString("dd'/'MM'/'yyyy"));
        }

        public IWebElement SetDepartureAndReturnElement()
        {
            var selectElement = new SelectElement(driver.FindElement(departure));
            selectElement.SelectByIndex(1);//Because "zero" value is default
            return selectElement.SelectedOption;
        }

        public SelectElement GetArrivalAirportOptions()
        {
            return new SelectElement(driver.FindElement(arrival));
        }

        public void SetDateTime(IWebElement el, string value)
        {
            el.SendKeys(value);
            CloseDatePicker();
        }

        public IWebElement GetElement(By selector)
        {
            return driver.FindElement(selector);
        }

        public void SubmitBookingForm()
        {
            driver.FindElement(bookingFormSubmitButton).Click();
        }

    }
}   