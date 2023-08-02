## Week 1 Quiz - Introduction to deep learning

1. What does the analogy “AI is the new electricity” refer to?

    - [ ] AI is powering personal devices in our homes and offices, similar to electricity.
    - [ ] Through the “smart grid”, AI is delivering a new wave of electricity.
    - [ ] AI runs on computers and is thus powered by electricity, but it is letting computers do things not possible before.
    - [x] Similar to electricity starting about 100 years ago, AI is transforming multiple industries.
    
    Note: Andrew illustrated the same idea in the lecture.

2. Which of these are reasons for Deep Learning recently taking off? (Check the two options that apply.)

    - [x] We have access to a lot more computational power.
    - [ ] Neural Networks are a brand new field.
    - [x] We have access to a lot more data.
    - [ ] Deep learning has resulted in significant improvements in important applications such as online advertising, speech recognition, and image recognition.

    Note: Both of these factors have played a significant role in advancing deep learning methods and allowing them to achieve state-of-the-art results in various applications, such as online advertising, speech recognition, and image recognition.
    
3. Recall this diagram of iterating over different ML ideas. Which of the statements below are true? (Check all that apply.)

    - [x] Being able to try out ideas quickly allows deep learning engineers to iterate more quickly.
    - [x] Faster computation can help speed up how long a team takes to iterate to a good idea. 
    - [ ] It is faster to train on a big dataset than a small dataset.
    - [x] Recent progress in deep learning algorithms has allowed us to train good models faster (even without changing the CPU/GPU hardware).

    Note: 
        1. With the advancements in deep learning frameworks, libraries, and tools, researchers and engineers can experiment with different ideas rapidly. This speeds up the development process and allows for faster exploration of potential improvements.
        2. While faster computation can help accelerate model training and evaluation, it doesn't directly impact the time taken to iterate over different ideas. Iteration speed is mainly influenced by the ease and speed of experimenting with various models and approaches.
        3. Generally, the training time on a larger dataset is longer compared to a smaller dataset. The training time is directly related to the size of the dataset and the complexity of the model. So, training on a bigger dataset may take more time, not less.
        4. Deep learning research has led to the development of more efficient algorithms, optimization techniques, and model architectures. These advancements have made it possible to train high-quality models faster than before, even without significant changes in the hardware used for training.

4. When an experienced deep learning engineer works on a new problem, they can usually use insight from previous problems to train a good model on the first try, without needing to iterate multiple times through different models. True/False?

    - [ ] True
    - [x] False
    
    Note: Maybe some experience may help, but nobody can always find the best model or hyperparameters without iterations.
          While an experienced deep learning engineer may have gained valuable insights and intuition from previous problems, it is not always guaranteed that they can train a good model on the first try for a new problem. Deep learning is a complex and challenging field, and the success of a model often depends on several factors, including the nature of the problem, the quality and size of the dataset, the model architecture, hyperparameters, and training techniques.
          Each problem has its unique characteristics, and it often requires trial and error to find the best model and configuration for that specific task.

5. Which one of these plots represents a ReLU activation function?

    - [![Rectifier-ReLU ](https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/ReLU_and_GELU.svg/1920px-ReLU_and_GELU.svg.png)

6. Images for cat recognition is an example of “structured” data, because it is represented as a structured array in a computer. True/False?
    
    - [ ] True
    - [x] False

    Note: Images for cat recognition are an example of "unstructured" data because they are represented as a collection of pixels without a predefined format or organization.
   
7. A demographic dataset with statistics on different cities' population, GDP per capita, economic growth is an example of “unstructured” data because it contains data coming from different sources. True/False?
    
    - [ ] True
    - [x] False

    Note: "Structured" data refers to data that is organized in a predefined format, such as tables or databases, where each data point has a specific meaning and is arranged in a systematic manner.
          In the given example, the data is likely organized in a tabular format, with each city's statistics represented as rows and different attributes like population, GDP per capita, and economic growth as columns. This structured organization allows for easy access, analysis, and processing of the data. The fact that the data may come from different sources does not make it "unstructured" but rather "multisource" or "heterogeneous" structured data.

8. Why is an RNN (Recurrent Neural Network) used for machine translation, say translating English to French? (Check all that apply.)

    - [x] It can be trained as a supervised learning problem.
    - [ ] It is strictly more powerful than a Convolutional Neural Network (CNN).
    - [x] It is applicable when the input/output is a sequence (e.g., a sequence of words).
    - [ ] RNNs represent the recurrent process of Idea->Code->Experiment->Idea->....

    Note: RNN is a type of deep learning architecture designed to process sequential data, like time series or natural language. Unlike traditional feedforward neural networks, RNNs have connections that create loops, allowing them to retain information from previous steps and use it in the current step of processing. This capability makes RNNs well-suited for tasks where the input or output is a sequence, enabling them to handle dependencies and patterns in the sequential data. However, traditional RNNs suffer from vanishing or exploding gradients, limiting their ability to capture long-term dependencies effectively. To address this, variants like LSTM (Long Short-Term Memory) and GRU (Gated Recurrent Unit) have been developed, which have become more popular choices for sequential tasks due to their ability to maintain and update information over longer time intervals.
   
9. In this diagram which we hand-drew in lecture, what do the horizontal axis (x-axis) and vertical axis (y-axis) represent?

    - x-axis is the amount of data
    - y-axis (vertical axis) is the performance of the algorithm.

10. Assuming the trends described in the previous question's figure are accurate (and hoping you got the axis labels right), which of the following are true? (Check all that apply.)

    - [x] Increasing the training set size generally does not hurt an algorithm’s performance, and it may help significantly.
    - [x] Increasing the size of a neural network generally does not hurt an algorithm’s performance, and it may help significantly.
    - [ ] Decreasing the training set size generally does not hurt an algorithm’s performance, and it may help significantly.
    - [ ] Decreasing the size of a neural network generally does not hurt an algorithm’s performance, and it may help significantly.
