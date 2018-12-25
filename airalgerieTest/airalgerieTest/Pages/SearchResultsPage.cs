using airalgerieTest.BaseEntities;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Threading;

namespace AirlinesTestingApp.Pages
{
    public class SearchResultsPage
    {
        private IWebDriver driver;
        public const string Url = "https://airalgerie.dz/en/search/?search=test";

        By searchBoxResults = By.XPath("/html/body/div[2]/div[1]/div[3]/div/ul/li");
        
        public SearchResultsPage()
        {
            this.driver = Driver.GetDriverInstance();
        }

        public void OpenSearchResultsPage()
        {
            GoToUrl(Url);
        }

        public void GoToUrl(string url)
        {
            driver.Navigate().GoToUrl(url);
        }

        public string GetSearchResultsText()
        {
            var searchResultsBoxElement = driver.FindElement(searchBoxResults);
            var content = searchResultsBoxElement.Text;
            return (content.Substring(content.IndexOf(":")+2));
        }

        public IWebElement GetElement(By selector)
        {
            return driver.FindElement(selector);
        }
    }
}   